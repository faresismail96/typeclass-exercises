package com.example.laws.discipline

import com.example.{Eq, Person}
import com.example.laws.EqLaws
import org.scalacheck.Arbitrary
import org.scalacheck.Prop.forAll
import org.typelevel.discipline.Laws

trait EqTests[A] extends Laws {
  def laws: EqLaws[A]

  def EqLawsRuleSet(implicit arb: Arbitrary[A]): RuleSet =
    new DefaultRuleSet(
      name = "Eq",
      parent = None,
      props =
        "reflexivity" -> forAll(laws.reflexivity _),
      "symmetry" -> forAll((a, b) => laws.symmetry(a, b)),
      "transitivity" -> forAll((a, b, c) => laws.transitivity(a, b, c))
    )
}
object EqTests {

  def apply[A](implicit eqA: Eq[A]): EqTests[A] = new EqTests[A] {
    override def laws: EqLaws[A] = new EqLaws[A] {
      override def eq: Eq[A] = eqA
    }
  }
}
