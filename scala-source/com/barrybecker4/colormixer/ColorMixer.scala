// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer

import java.awt.Toolkit
import java.awt.event.{WindowAdapter, WindowEvent}

import com.barrybecker4.colormixer.ui.ColorMixerPanel
import com.barrybecker4.ui.application.ApplicationApplet
import com.barrybecker4.ui.util.GUIUtil
import javax.swing._


object ColorMixer extends App {
  val mixer = new ColorMixer(args)

  mixer.getContentPane.setSize(600, 900)
  println("size = " + mixer.getContentPane.getSize())

  GUIUtil.showApplet(mixer)
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