package org.certificatic.practica1.interfaces.livingbeing.test;

import org.certificatic.practica1.interfaces.livingbeing.api.BugEater;
import org.certificatic.practica1.interfaces.livingbeing.api.LivingBeing;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Aardvark;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Animal;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Plant;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.VenusFlyTrap;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LivingBeingTest {

	@Test
	public void livingBeingTest() {
		log.info("livingBeingTest -------------------");

		// Implementar
		LivingBeing livingBeing1 = new Aardvark();
		LivingBeing livingBeing2 = new VenusFlyTrap();

		Assert.assertNotNull(livingBeing1);
		Assert.assertTrue(livingBeing2 != null);

		Assert.assertTrue(livingBeing1 instanceof LivingBeing);
		Assert.assertTrue(livingBeing1 instanceof BugEater);
		Assert.assertTrue(livingBeing1 instanceof Animal);

		Assert.assertTrue(livingBeing2 instanceof LivingBeing);
		Assert.assertTrue(livingBeing2 instanceof BugEater);
		Assert.assertTrue(livingBeing2 instanceof Plant);

		livingBeing1.born();
		livingBeing1.grow();
		livingBeing1.breed();
		livingBeing1.die();

		((BugEater) livingBeing1).eatBug();

		livingBeing2.born();
		livingBeing2.grow();
		livingBeing2.breed();
		livingBeing2.die();

		((BugEater) livingBeing2).eatBug();
	}

}
