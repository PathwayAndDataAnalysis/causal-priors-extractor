package org.panda.cpe;

import org.biopax.paxtools.pattern.Pattern;

/**
 * Negative expression pattern 1.
 *
 * @author Ozgun Babur
 */
public class EN1 extends EP1
{
	public EN1()
	{
		setType(SignedType.DOWNREGULATES_EXPRESSION);
	}

	@Override
	public Pattern constructPattern()
	{
		Pattern p = super.constructPattern();
		p.removeLastConstraint();
		p.add(new ControlSignConstraint(ControlSignConstraint.Sign.NEGATIVE), "Control");
		return p;
	}
}
