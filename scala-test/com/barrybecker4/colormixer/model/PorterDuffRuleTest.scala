package com.barrybecker4.colormixer.model

import com.barrybecker4.common.app.AppContext
import com.barrybecker4.ui.util.Log
import java.awt.AlphaComposite
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite

class PorterDuffRuleTest extends AnyFunSuite with BeforeAndAfterAll:

  /** Rule names are loaded from the app bundle, which AppContext only sees after initialize. */
  override def beforeAll(): Unit =
    super.beforeAll()
    if !AppContext.isInitialized then
      AppContext.initialize(
        "ENGLISH",
        List("com.barrybecker4.colormixer.message"),
        new Log
      )

  test("rule toString") {
    assertResult("PorterDuffRule(foo,bar,1)") {
      PorterDuffRule("foo", "bar", AlphaComposite.CLEAR).toString
    }
  }

  test("porterDuffRules length matches AlphaComposite constants") {
    val expected = Seq(
      AlphaComposite.DST_ATOP,
      AlphaComposite.DST_IN,
      AlphaComposite.DST_OUT,
      AlphaComposite.DST_OVER,
      AlphaComposite.SRC_ATOP,
      AlphaComposite.SRC_IN,
      AlphaComposite.SRC_OUT,
      AlphaComposite.SRC_OVER,
      AlphaComposite.CLEAR,
      AlphaComposite.XOR
    )
    assert(porterDuffRules.length == expected.length)
    porterDuffRules.map(_.compositeRule).zip(expected).foreach { case (actual, exp) =>
      assert(actual == exp)
    }
  }

  test("porterDuffRules names are non-empty") {
    porterDuffRules.foreach(r =>
      assert(r.name.nonEmpty && r.description.nonEmpty)
    )
  }
