// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer

import com.barrybecker4.ui.application.ApplicationApplet
import com.barrybecker4.ui.util.GUIUtil
import javax.swing._


object ColorMixer extends App {
  val simulator = new ColorMixer
  GUIUtil.showApplet(simulator)
}

/**
  * Demo to show all the different Porter/Duff rules for  colors mixing using Java2D API.
  * @author Barry Becker
  */
class ColorMixer extends ApplicationApplet {

  override def createMainPanel: JPanel = {
    ColorMixerPanel()
  }

  override def getName = "Color Mixer"
}