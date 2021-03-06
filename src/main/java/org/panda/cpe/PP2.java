package org.panda.cpe;

import org.biopax.paxtools.pattern.Match;
import org.biopax.paxtools.pattern.Pattern;
import org.biopax.paxtools.pattern.constraint.ConBox;
import org.biopax.paxtools.pattern.constraint.ModificationChangeConstraint;
import org.biopax.paxtools.pattern.constraint.NOT;
import org.biopax.paxtools.pattern.miner.CSCOButIsParticipantMiner;
import org.biopax.paxtools.pattern.miner.IDFetcher;
import org.biopax.paxtools.pattern.miner.SIFInteraction;

import java.util.Set;

/**
 * @author Ozgun Babur
 */
public class PP2 extends CSCOButIsParticipantMiner
{
	public PP2()
	{
		setType(SignedType.PHOSPHORYLATES);
	}

	@Override
	public Pattern constructPattern()
	{
		Pattern p = super.constructPattern();
		p.add(new NOT(ConBox.linkToSpecific()), "input PE", "output simple PE");
		p.add(new NOT(ConBox.linkToSpecific()), "output PE", "input simple PE");
		p.add(new ModificationChangeConstraint(ModificationChangeConstraint.Type.GAIN, "phospho"),
			"input simple PE", "output simple PE");
		return p;
	}

	@Override
	public Set<SIFInteraction> createSIFInteraction(Match m, IDFetcher fetcher)
	{
		PhosphoInteractionCreator pic = new PhosphoInteractionCreator(this);
		return pic.create(m, fetcher, getSIFType().equals(SignedType.PHOSPHORYLATES));
	}
}
