// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer

import com.barrybecker4.colormixer.ui.ColorMixerPanel
import com.barrybecker4.ui.application.ApplicationApplet
import com.barrybecker4.ui.util.GUIUtil
import javax.swing._


object ColorMixer extends App {
  println("args = " + args.mkString(", "))
  val simulator = new ColorMixer(args)
  GUIUtil.showApplet(simulator)
}

/**
  * Demo to show all the different Porter/Duff rules for  colors mixing using Java2D API.
  * @author Barry Becker
  */
class ColorMixer(args: Array[String]) extends ApplicationApplet(args) {

  override def createMainPanel: JPanel = {
    ColorMixerPanel()
  }
}