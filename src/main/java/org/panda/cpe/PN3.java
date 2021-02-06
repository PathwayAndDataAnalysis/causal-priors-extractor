package org.panda.cpe;

import org.biopax.paxtools.pattern.Pattern;
import org.biopax.paxtools.pattern.constraint.ModificationChangeConstraint;

/**
 * @author Ozgun Babur
 */
public class PN3 extends PP3
{
	public PN3()
	{
		setType(SignedType.DEPHOSPHORYLATES);
	}

	@Override
	public Pattern constructPattern()
	{
		Pattern p = super.constructPattern();
		p.removeLastConstraint();
		p.add(new ModificationChangeConstraint(ModificationChangeConstraint.Type.LOSS, "phospho"),
			"input simple PE", "output simple PE");
		return p;
	}
}
