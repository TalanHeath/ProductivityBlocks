package com.ardublock.translator.block.ADC.HSC;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class P1_HSC_Channel  extends TranslatorBlock {

	public P1_HSC_Channel (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			//create internal variable if it hasn't been created yet
			String internalVariableName = translator.getNumberVariable(label);
			if (internalVariableName == null)
			{
				internalVariableName = translator.buildVariableName(label);
				translator.addNumberVariable(label, internalVariableName);
			}
			return codePrefix + internalVariableName + codeSuffix;
		}
}