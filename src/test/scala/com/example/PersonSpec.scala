package com.example

import com.example.laws.discipline.EqTests

class PersonSpec extends MySpec {
  checkAll(
    "Eq[Person] by name",
    EqTests(Person.Instances.eqByName).EqLawsRuleSet
  )
  checkAll("Eq[Person] by id", EqTests(Person.Instances.eqById).EqLawsRuleSet)
}
