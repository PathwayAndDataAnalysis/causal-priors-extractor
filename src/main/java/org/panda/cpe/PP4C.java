package org.panda.cpe;

import org.biopax.paxtools.model.level3.Complex;
import org.biopax.paxtools.pattern.Pattern;
import org.biopax.paxtools.pattern.constraint.NOT;
import org.biopax.paxtools.pattern.constraint.Type;

/**
 * @author Ozgun Babur
 */
public class PP4C extends PP4
{
	@Override
	public Pattern constructPattern()
	{
		Pattern p = super.constructPattern();
		p.add(new NOT(new Type(Complex.class)), "upper controller PE");
		return p;
	}
}
