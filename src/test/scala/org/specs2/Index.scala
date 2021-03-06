package org.specs2

import guide.{UserGuideVariables, Specs2Variables}
import io.FileSystem
import scala.io.Source
import Specs2Variables._

class Index extends Specification with FileSystem with UserGuideVariables { def is =
  "create a new index page"    ! createPage("index.html", indexBody)^
  "create a new sponsors page" ! createPage("sponsors.html", sponsorsBody)

  def createPage(fileName: String, body: String, outputDir: String = "target/specs2-reports/") = {
    writeFile(outputDir+fileName, createHtml(body))
    ok
  }

def createHtml(body: String) = s"""
<!DOCTYPE html>
<html>
 $head
<body>
$top
$sidebar
$body
$footer
</body>
</html>
"""

def head =
  s"""
<head>
  <meta charset='utf-8'>
  <!-- PLEASE DEAR READER PARDON MY LACK OF HTML/CSS SKILLS :-) Any contribution will be gladly accepted! -->
  <title>etorreborre/specs2 @ GitHub</title>
      <style type="text/css" media="all">
        @import url('./css/maven-base.css');
        @import url('./css/maven-theme.css');
      </style>
      <link href="./css/prettify.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript" src="./css/prettify.js"></script>
      <link href="./css/print.css" type="text/css" rel="stylesheet" media="print" />
      <link href="./css/tooltip.css" type="text/css" rel="stylesheet" />
      <script type="text/javascript" src="./css/tooltip.js"></script>
      <script language="javascript">
      function init() {  prettyPrint(); };
      /* found on : http://www.tek-tips.com/faqs.cfm?fid=6620 */
      String.prototype.endsWith = function(str) { return (this.match(str+'$$') == str) };
      function changeWidth(id,width) {  document.getElementById(id).style.width = width; };
      function changeMarginLeft(id, margin) { document.getElementById(id).style.marginLeft = margin; };
      function toggleImage(image) {
        if (image.src.endsWith('./images/expanded.gif'))
          image.src = './images/collapsed.gif';
        else
          image.src = './images/expanded.gif';
      };
      function showHide(id) {
        element = document.getElementById(id);
        element.style.display = (element.style.display == 'block')? 'none' : 'block';
      };
    </script>
      <script language="javascript">window.onload=init;</script>
      <!-- the tabber.js file must be loaded after the onload function has been set, in order to run the
           tabber code, then the init code -->
      <script type="text/javascript" src="./css/tabber.js"></script>
      <link href="./css/tabber.css" type="text/css" rel="stylesheet" media="screen" />
    <style type="text/css">
  #top {
      margin-left: 150px;
      width: 60%;
    }
    #container {
      margin-left: 150px;
      width: 74%;
    float: left;
    }
  #sidebar {
      width:13%;
      float:right;
    }
  .console { font-family:Courier; color: #CCCCCC; background: #000000; border: 1px #CCCCCC; padding: 10px; }
    .description { font-size: 1.1em; margin-bottom: 30px; margin-top: 0px; font-style: italic;}
    .footer { text-align:center; padding-top:30px; font-style: italic; }
    .download { float: right; }
  s2 { font-style: italic; }
  .sidelink { margin-left: 8px; }
    hr { border: 0; width: 80%; border-bottom: 1px solid #aaa}
  </style>
  <script type="text/javascript">

    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-965071-4']);
    _gaq.push(['_trackPageview']);

    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();

  </script>
  </head>
"""

def top = s"""
  <div id="top">
      <a href="http://github.com/etorreborre/specs2"><img style="position: right; border: 0; width: 17%" src="./images/specs2.png" alt="specs2" /></a>
      <div class="description">Software Specifications for Scala</div>
  </div>
"""

def sidebar = s"""
   <div id="sidebar">
   <h3 style="margin-top: 0; margin-bottom: 0;">Try it!</h3>
   <div class="sidelink" style="margin-top: 10px;"><a href="http://github.com/etorreborre/specs2-test">Sample project</a> (<a href="http://github.com/etorreborre/specs2-test/tarball/SPECS2-${VERSION}">tar</a>, <a href="http://github.com/etorreborre/specs2-test/zipball/SPECS2-${VERSION}">zip</a>)<br/>
   </div>
   <a class="sidelink" href="#Dependencies">Dependencies</a><br/>
   <a class="sidelink" href="#Downloads">Downloads</a><br/>
   <h3 style="margin-bottom: 0;">Learn it!</h3>
   <div class="sidelink" style="margin-top: 10px;"><a href="guide/org.specs2.guide.QuickStart.html">Quick Start</a><br/>
   </div>
   <a class="sidelink" href="guide/org.specs2.guide.UserGuide.html">User Guide</a><br/>
   <a class="sidelink" href="${EXAMPLES_OFFICIAL_DIR}">Examples</a><br/>
   <a class="sidelink" href="${API_OFFICIAL_DIR}index.html">Scaladoc</a><br/>
   <h3 style="margin-bottom: 0;">Get involved!</h3>
   <div style="margin-top: 10px;"><a class="sidelink" href="http://github.com/etorreborre/specs2">Github project</a>
   </div>
   <a class="sidelink"   href="http://groups.google.com/group/specs2-users">User group</a><br/>
   <a class="sidelink" href="http://github.com/etorreborre/specs2/issues">Issues</a><br/>
   <a class="sidelink" href="http://etorreborre.blogspot.com/search/label/specs2">Blog</a><br/>
   <a class="sidelink" href="sponsors.html">Sponsors</a><br/>
   <h3 style="margin-bottom: 0;">Stay informed!</h3><br/>
   <a class="sidelink" href="http://etorreborre.blogspot.com/search/label/specs2">Blog</a><br/>
   <a class="sidelink" href="http://notes.implicit.ly/tagged/specs2">Announcements</a><br/>
   <div class="sidelink"><a href="https://twitter.com/specs2org" class="twitter-follow-button" data-show-count="false" data-show-screen-name="false" data-dnt="true">Follow @specs2org</a>
   <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script></div>
</div>
"""

def footer = s"""
<div class="footer">
  get the source code on GitHub : <a href="http://github.com/etorreborre/specs2">etorreborre/specs2</a>
</div>
"""

def indexBody =
s"""
  <div id="container">
    <h3 style="margin-top:0;">Presentation</h3>

    <s2>specs2</s2> is a library for writing executable software specifications.
  <p/>
  With <s2>specs2</s2> you can write software specifications for one class (<i>unit</i> specifications) or a full system (<i>acceptance</i> specifications):

  <div class="tabber">
    <div class="tabbertab" title="Unit">
      <code class="prettyprint">   import org.specs2.mutable._

  class HelloWorldSpec extends Specification {

    "The 'Hello world' string" should {
      "contain 11 characters" in {
        "Hello world" must have size(11)
      }
      "start with 'Hello'" in {
        "Hello world" must startWith("Hello")
      }
      "end with 'world'" in {
        "Hello world" must endWith("world")
      }
    }
  }</code>
    </div>
    <div class="tabbertab" title="Acceptance">
      <code class="prettyprint">   import org.specs2._

  class HelloWorldSpec extends Specification { def is = s2$triple

    This is a specification to check the 'Hello world' string

    The 'Hello world' string should
      contain 11 characters                             $$e1
      start with 'Hello'                                $$e2
      end with 'world'                                  $$e3
                                                        $triple

    def e1 = "Hello world" must have size(11)
    def e2 = "Hello world" must startWith("Hello")
    def e3 = "Hello world" must endWith("world")
  }</code>
    </div>
  </div>
  <p/>

  <h3 style="margin-top:20px">Features</h3>

  The features of <s2>specs2</s2> are:<p/>
  <div class="level1"><img src="./images/collapsed.gif">Concurrent execution of examples by default</img></div>
  <div class="level1"><img src="./images/collapsed.gif"><a href="http://code.google.com/p/scalacheck/">ScalaCheck</a> properties</img></div>
  <div class="level1"><img src="./images/collapsed.gif">Mocks with <a href="http://mockito.org/">Mockito</a></img></div>
  <div class="level1"><img src="./images/collapsed.gif">Data tables</img></div>
  <div class="level1"><img src="./images/collapsed.gif">AutoExamples, where the source code is extracted to describe the example</img></div>
  <div class="level1"><img src="./images/collapsed.gif">A rich library of matchers</img></div>
    <div class="level2"><img src="./images/collapsed.gif">Easy to create and compose</img></div>
    <div class="level2"><img src="./images/collapsed.gif">Usable with <code>must</code> and <code>should</code></img></div>
    <div class="level2"><img src="./images/collapsed.gif">Returning "functional" results or throwing exceptions</img></div>
    <div class="level2"><img src="./images/collapsed.gif">Reusable outside of specs2 (in <a href="http://junit.org">JUnit</a> tests for example)</img></div>
  <div class="level1"><img src="./images/collapsed.gif">Forms for writing <a href="http://fitnesse.org">Fitnesse</a>-like specifications (with Markdown markup)</img></div>
  <div class="level1"><img src="./images/collapsed.gif">Html reporting to create documentation for acceptance tests, to create a User Guide</img></div>
  <div class="level1"><img src="./images/collapsed.gif"/><a href="http://etorreborre.github.io/specs2/guide/org.specs2.guide.HowTo.html#Capture+snippets">Snippets</a> for documenting APIs with always up-to-date code</div>
  <div class="level1"><img src="./images/collapsed.gif">Integration with <a href="http://scala-sbt.org/">sbt</a> and JUnit tools (maven, IDEs,...)</img></div>

    <h3><a name="Dependencies"></a>Dependencies</h3>
    The <s2>specs2</s2> jar is available with both sbt and maven

  <div class="tabber">
    <div class="tabbertab" title="sbt">
        <code class="prettyprint">
  libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "${VERSION}" % "test"

    // with Scala 2.9.3 (specs2 1.12.4.1 is the latest version for scala 2.9.3)
    // "org.specs2" %% "specs2" % "1.12.4.1" % "test",
  )

  scalacOptions in Test ++= Seq("-Yrangepos")

  // Read here for optional dependencies:
  // <a href="http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies">http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies</a>

  resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases")
</code>
      </div>
    <div class="tabbertab" title="maven">
        <code class="prettyprint">  &lt;dependency>
   &lt;groupId>org.specs2&lt;/groupId>
   &lt;artifactId>specs2_2.10&lt;/artifactId>
   &lt;version>${VERSION}&lt;/version>
   &lt;scope>test&lt;/scope>
 &lt;/dependency>


 &lt;!--
   with Scala 2.9.3, change the dependency to:

   &lt;artifactId>specs2_2.9.3&lt;/artifactId>
   &lt;version>1.12.4.1&lt;/version>

 -->

 &lt;!--
  Read here for optional dependencies:
  <a href="http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies">http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies</a>
 -->

 &lt;repository>
   &lt;id>oss.sonatype.org&lt;/id>
   &lt;name>releases&lt;/name>
   &lt;url>http://oss.sonatype.org/content/repositories/releases&lt;/url>
 &lt;/repository>

 &lt;repository>
   &lt;id>oss.sonatype.org&lt;/id>
   &lt;name>snapshots&lt;/name>
   &lt;url>http://oss.sonatype.org/content/repositories/snapshots&lt;/url>
 &lt;/repository>

 &lt;repository>
   &lt;id>central&lt;/id>
   &lt;name>Maven repository&lt;/name>
   &lt;url>http://repo1.maven.org/maven2&lt;/url>
 &lt;/repository>

    </code>
      </div>
  </div>

    <h3><a name="Downloads"></a>Downloads</h3>

  You can download the project here
  <table width="850">
    <tr><th width="100">Version</th><th width="400">Files</th></tr>
    <tr>
        <td class="info">Snapshot</td>
        <td class="info">
        binaries (<a href="http://oss.sonatype.org/content/repositories/snapshots/org/specs2/specs2_2.10/${SNAPSHOT_VERSION}/">specs2 jar</a>,
                  <a href="http://oss.sonatype.org/content/repositories/releases/org/scalaz/scalaz-core_2.10/7.0.2/">scalaz core jar</a>,
                  <a href="http://oss.sonatype.org/content/repositories/releases/org/scalaz/scalaz-concurrent_2.10/7.0.2/">scalaz concurrent jar</a>)<br/>
       project (<a href="http://github.com/etorreborre/specs2/zipball/master">zip</a>,
                <a href="http://github.com/etorreborre/specs2/tarball/master">tar</a>)
      </td>
    </tr>
    <tr>
        <td class="info">Released</td>
        <td class="info">
        binaries (<a href="http://oss.sonatype.org/content/repositories/releases/org/specs2/specs2_2.10/${VERSION}/">specs2 jar</a>,
                  <a href="http://oss.sonatype.org/content/repositories/releases/org/scalaz/scalaz-core_2.10/7.0.2/">scalaz core jar</a>,
                  <a href="http://oss.sonatype.org/content/repositories/releases/org/scalaz/scalaz-concurrent_2.10/7.0.2/">scalaz concurrent jar</a>)<br/>
        project (<a href="http://github.com/etorreborre/specs2/zipball/SPECS2-${VERSION}">zip</a>,
                 <a href="http://github.com/etorreborre/specs2/tarball/SPECS2-${VERSION}">tar</a>)
      </td>
    </tr>
  <table>
    <p>You can also clone the project with <a href="http://git-scm.com">Git</a>
      by running:
      <div class="console">$$ git clone git://github.com/etorreborre/specs2</div>
    </p>

  </div>
"""

def sponsorsBody =
  s"""
   <div id="container">
    <h3 style="margin-top:0;">Sponsors</h3>

    <s2>specs2</s2> development is supported by:
       <p/>
       <img src="./images/yourkit.jpg" height="25" width="25"></img><b>  <a href="http://www.yourkit.com/">YourKit</a></b>
     <p/>
       YourKit is kindly supporting open source projects with its full-featured Java Profiler.
       YourKit, LLC is the creator of innovative and intelligent tools for profiling
       Java and .NET applications. Take a look at YourKit's leading software products:
       <a href="http://www.yourkit.com/java/profiler/index.jsp">YourKit Java Profiler</a> and
       <a href="http://www.yourkit.com/.net/profiler/index.jsp">YourKit .NET Profiler</a>.
       <p/>
       <img src="./images/BuiltOnDEV.png" height="25" width="25" ></img><b>  <a href="http://www.cloudbees.com">Cloudbees</a></b>
     <p/>
       "At CloudBees, a group of us have a strong history of contributing and leading Free and Open Source (FOSS) projects. Consequently, we have first hand experience surrounding the challenges that FOSS projects present. As an open source developer, you want to focus on the features of your project and its quality -- you don't want to spend your time configuring and worrying about build and test servers."
       <p/>
     <img src="./images/BuiltOnDEV.png"></img>
     <p/>

  </div>
  """
}
