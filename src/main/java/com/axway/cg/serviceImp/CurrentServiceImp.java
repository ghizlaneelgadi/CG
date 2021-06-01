package com.axway.cg.serviceImp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.axway.cg.domain.current_test;
import com.axway.cg.service.CurrentService;

@Service
public class CurrentServiceImp implements CurrentService {

	private Long currentId = 1L;
	private Long currentI = 2L;
	private Long crtId = 3L;
	private Long Id = 4L;
	private Map<Long, current_test> currentMap = new HashMap<Long, current_test>();

	{
		current_test current = new current_test();
		current.setId(currentId);
		current.setSenddate("2020-03-01");
		current.setSendtime("08:05:47");
		current.setEnddate("2020-03-01");
		current.setEndtime("08:05:49");
		current.setFlowidentifier("Flow 1");
		current.setFlowname("Flow test 1");
		current.setPriority("Medium");
		current.setStatus("Completed");
		current.setProtocol("PeSit");
		current.setSourceapp("frontal");
		current.setTargetapp("AGIRH");
		current.setFilename("...................");

		currentMap.put(current.getId(), current);

		current_test curren = new current_test();
		curren.setId(currentI);
		curren.setSenddate("2020-03-01");
		curren.setSendtime("09:05:13");
		curren.setEnddate("2020-03-01");
		curren.setEndtime("09:08:15");
		curren.setFlowidentifier("Flow 1");
		curren.setFlowname("Flow test 1");
		curren.setPriority("Medium");
		curren.setStatus("Canceled");
		curren.setProtocol("PeSit");
		curren.setSourceapp("frontal");
		curren.setTargetapp("AGIRH");
		curren.setFilename("...................");

		currentMap.put(curren.getId(), curren);

		current_test crt = new current_test();
		crt.setId(crtId);
		crt.setSenddate("2020-03-01");
		crt.setSendtime("09:05:03");
		crt.setEnddate("2020-03-01");
		crt.setEndtime("09:08:57");
		crt.setFlowidentifier("Flow 1");
		crt.setFlowname("Flow test 1");
		crt.setPriority("Medium");
		crt.setStatus("Completed");
		crt.setProtocol("PeSit");
		crt.setSourceapp("frontal");
		crt.setTargetapp("AGIRH");
		crt.setFilename("...................");

		currentMap.put(crt.getId(), crt);

		current_test ct = new current_test();
		ct.setId(Id);
		ct.setSenddate("2020-03-01");
		ct.setSendtime("09:55:08");
		ct.setEnddate("2020-11-02");
		ct.setEndtime("09:57:18");
		ct.setFlowidentifier("Flow 1");
		ct.setFlowname("Flow test 1");
		ct.setPriority("Medium");
		ct.setStatus("Completed");
		ct.setProtocol("PeSit");
		ct.setSourceapp("frontal");
		ct.setTargetapp("AGIRH");
		ct.setFilename("...................");

		currentMap.put(ct.getId(), ct);
	}

	@Override
	public Collection<current_test> findAll() {
		return currentMap.values();
	}

	@Override
	public current_test findById(Long Id) {
		return currentMap.get(Id);
	}

	@Override
	public current_test save(current_test current) {
		Long newCurrentId = ++currentId;
		current.setId(newCurrentId);
		currentMap.put(current.getId(), current);
		return currentMap.get(newCurrentId);
	}

	@Override
	public current_test update(current_test current) {
		currentId = current.getId();
		if (currentMap.get(currentId) != null) {
			currentMap.put(currentId, current);
			return currentMap.get(currentId);
		}
		return null;
	}

	@Override
	public current_test deleteById(Long Id) {
		if (currentMap.get(Id) != null) {
			return currentMap.remove(Id);
		}
		return null;
	}

}
