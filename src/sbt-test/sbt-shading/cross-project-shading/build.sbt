
lazy val root = crossProject
  .in(file("."))
  .enablePlugins(ShadingPlugin)
  .settings(
    shadedModules += "io.argonaut" %% "argonaut",
    shadingRules += ShadingRule.moveUnder("argonaut", "foo.shaded"),
    validNamespaces += "foo",
    libraryDependencies += "io.argonaut" %% "argonaut" % "6.2-RC2",
    scalaJSUseMainModuleInitializer := true,
    scalaVersion := "2.11.12",
    organization := "io.get-coursier.test",
    name := "shading-cross-test",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
  )

lazy val jvm = root.jvm
lazy val js = root.js
