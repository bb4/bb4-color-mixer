package com.barrybecker4.colormixer.model

import java.awt.AlphaComposite
import org.scalatest.funsuite.AnyFunSuite

class PorterDuffRuleTest extends AnyFunSuite {

  test("rule serialization") {
    assertResult("PorterDuffRule(foo,bar,1)") {
      PorterDuffRule("foo", "bar", AlphaComposite.CLEAR).toString
    }
  }

  test("num rules") {
    assertResult(11 ) { com.barrybecker4.colormixer.model.porterDuffRules.length }
  }
}
