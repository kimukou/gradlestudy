//
// copy to https://gist.github.com/293693
//

//#!/usr/bin/env groovy
@Grab('nekohtml:nekohtml:latest.integration')
import org.cyberneko.html.parsers.SAXParser
import groovy.xml.DOMBuilder
import groovy.xml.XmlUtil
import groovy.xml.dom.DOMCategory

/*
 * gaelyk - utility wrapper command for Gaelyk.
 * 2010/02/03 ksky@jggug.org
 */

// main
def home = System.getenv('APPENGINE_HOME')
if (!home) { die 'Please set the APPENGINE_HOME environment variable.' }
def jar = "$home/lib/appengine-tools-api.jar"
this.class.classLoader.rootLoader.addURL(new File(jar).toURL())
// Google's KickStart class uses this property
def cp = System.getProperty('java.class.path')
System.setProperty('java.class.path', cp + File.pathSeparator + jar)

def target
try {
	if (!args) { warn '<target> must be specified.'; doHelp() }
	target = args[0]
	def method = 'do' + target.replaceAll(/^.|-./, { it[-1].toUpperCase() })
	invokeMethod(method, null)
} catch (MissingMethodException mmex) {
	warn "Invalid target: $target"
	doHelp()
} catch (ex) {
	ex.printStackTrace()
}

def doCreateApp() {
	if (args.size() < 2) { warn '<appId> must be specified.'; doHelp() }
	def appId = args[1]
	if (new File(appId).exists()) { die "$appId already exists."}
	
	// download & unzip the template project file
	def zipFile = latestTemplateProject()
	def url = "http://cloud.github.com/downloads/glaforge/gaelyk/$zipFile"
	def cache = new File(System.getProperty('java.io.tmpdir'), zipFile)
	def ant = new AntBuilder()
	if (!cache.exists()) { ant.get(src:url, dest:cache) }
	ant.unzip(src:cache, dest:appId)

	// modify appengine-web.xml
	def xmlFile = new File("$appId/war/WEB-INF/appengine-web.xml")
	def root = xmlFile.withReader { DOMBuilder.parse(it).documentElement }
	use(DOMCategory) {
		root.application.item(0).value = appId
		/* these props became default since gaelyk 0.3.3
		def props = root.appendNode('system-properties')
		props.appendNode('property', [name:'file.encoding', value:'UTF-8'])
		props.appendNode('property', [name:'groovy.source.encoding', value:'UTF-8'])
		*/
	}
	xmlFile.write(XmlUtil.serialize(root))
	warn 'appengine-web.xml successfully modified.'
}

def doRunApp() {
	evaluate """String[] args = [ 'com.google.appengine.tools.development.DevAppServerMain', 'war' ]
	com.google.appengine.tools.KickStart.main(args)"""
}

def doDeploy() {
	evaluate """String[] args = [ 'update', 'war' ]
	com.google.appengine.tools.admin.AppCfg.main(args)"""
}

// need Java 6+
def doTutorial() {
	final tutorialPage = 'http://gaelyk.appspot.com/tutorial'
	java.awt.Desktop.desktop.browse(tutorialPage.toURI())
}

def doHelp() {
	die	'''Usage: gaelyk <target> [args ...]
Available targets:
  create-app <appId> - create new project
  run-app  - run your application locally
  deploy   - deploy your application in the cloud
  tutorial - display Gaelyk tutorial in your browser
  help     - print this help'''
}

def warn(msg) { System.err.println msg }
def die(msg) { warn msg; System.exit 1 }

// get the file name of the latest template project (by scraping)
def latestTemplateProject() {
	final page = 'http://github.com/glaforge/gaelyk/downloads'
	final pat = /gaelyk-template-project-[\d\.]+\.zip/
	def html = new XmlParser(new SAXParser()).parse(page)
	def rows = html.'**'.TABLE[0].TR[1..-1]
	def files = []
	rows.each { tr ->
		def file = tr.TD[1]?.A?.text()
		if (file ==~ pat) { files << [file:file, date:tr.TD[3].text()] }
	}
	files.sort { it.date }[-1].file
}
