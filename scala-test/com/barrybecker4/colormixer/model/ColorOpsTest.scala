package com.barrybecker4.colormixer.model

import java.awt.Color
import org.scalatest.funsuite.AnyFunSuite

class ColorOpsTest extends AnyFunSuite:

  test("withOpacity scales alpha for mid opacity") {
    val c = new Color(10, 20, 30, 0)
    val out = ColorOps.withOpacity(c, 0.5f)
    assert(out.getAlpha == 128)
    assert(out.getRed == 10 && out.getGreen == 20 && out.getBlue == 30)
  }

  test("withOpacity clamps opacity above 1") {
    val c = new Color(0, 0, 0, 0)
    val out = ColorOps.withOpacity(c, 2f)
    assert(out.getAlpha == 255)
  }

  test("withOpacity clamps opacity below 0") {
    val c = new Color(0, 0, 0, 200)
    val out = ColorOps.withOpacity(c, -1f)
    assert(out.getAlpha == 0)
  }

  test("withOpacity zero opacity") {
    val c = new Color(99, 88, 77, 255)
    val out = ColorOps.withOpacity(c, 0f)
    assert(out.getAlpha == 0)
  }

  test("withOpacity full opacity") {
    val c = new Color(1, 2, 3, 0)
    val out = ColorOps.withOpacity(c, 1f)
    assert(out.getAlpha == 255)
  }
