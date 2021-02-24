package com.autotune.queue;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.autotune.em.utils.EMUtils.QueueName;

public class ExpMgrQueue implements AutotuneQueue, Serializable {
	private static final long serialVersionUID = -6045964856984857449L;
	private final int INITIAL_CAPACITY = 50;
	private final BlockingQueue<AutotuneDTO> queue;
	private final String name;
	private static ExpMgrQueue instance;

	private ExpMgrQueue()
	{
		this.name = QueueName.EXPMGRQUEUE.name();
		queue = new LinkedBlockingQueue<AutotuneDTO>(INITIAL_CAPACITY);
	}

	public static ExpMgrQueue getInstance()
	{
		if (instance == null)
		{
			synchronized(ExpMgrQueue.class)
			{
				if (instance == null)
				{
					instance = new ExpMgrQueue();
				}
			}            
		}

		return instance;
	} 
	//
	private Object readResolve() {
		return getInstance();
	}
	
	@Override
	public boolean send(AutotuneDTO data) throws InterruptedException {
		return queue.offer(data);
	}
	
	@Override
	public AutotuneDTO get() throws InterruptedException {
		return queue.take();
	}
	
	@Override
	public String getName() {
		return this.name;
	}
		
}
