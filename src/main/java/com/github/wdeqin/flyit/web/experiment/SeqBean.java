package com.github.wdeqin.flyit.web.experiment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wdeqin.flyit.data.dao.SeqMapper;
import com.github.wdeqin.flyit.data.model.Seq;

public class SeqBean implements RmiHandler {
	private Logger logger;
	private SeqMapper seqMapper;

	public SeqBean() {
		logger = LogManager.getLogger("com.flyit.web");
	}


	public void setSeqMapper(SeqMapper seqMapper) {
		this.seqMapper = seqMapper;
	}


	public String handle(RmiPack pack) {
		try {
			logger.debug(pack);
			Seq seq = new Seq();
			seq.setSeqnam("#TSTSEQ#");
			seqMapper.nxtVal(seq);
			return seq.getNxtval().toString();
		} catch (Exception e) {
			logger.error(e);
			return e.toString();
		}
	}
}
