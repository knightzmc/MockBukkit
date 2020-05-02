package be.seeseemelk.mockbukkit.scheduler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepeatingTaskTest
{

	@Test
	public void getScheduledTick_Start_IsEqualToDelay()
	{
		RepeatingTask task = new RepeatingTask(0, null, true, 10, 20, null);
		assertEquals(10, task.getScheduledTick());
	}

	@Test
	public void getScheduledTick_AfterUpdateScheduledTick_Changed()
	{
		RepeatingTask task = new RepeatingTask(0, null, true, 10, 20, t -> {});
		task.updateScheduledTick();
		assertEquals(30, task.getScheduledTick());
	}

	@Test
	public void getPeriod_SomePeriod_ExactPeriod()
	{
		RepeatingTask task = new RepeatingTask(0, null, true, 10, 20, null);
		assertEquals(20, task.getPeriod());
	}

}
