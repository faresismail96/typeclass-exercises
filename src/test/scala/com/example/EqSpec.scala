package com.example

import com.example.laws.discipline.EqTests

class EqSpec extends MySpec {
  checkAll("Eq[Int]", EqTests[Int].EqLawsRuleSet)
  checkAll("Eq[String]", EqTests[String].EqLawsRuleSet)
  checkAll("Eq[Person]", EqTests[Person].EqLawsRuleSet)
}
