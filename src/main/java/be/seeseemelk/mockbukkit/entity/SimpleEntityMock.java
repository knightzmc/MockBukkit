package be.seeseemelk.mockbukkit.entity;

import java.util.UUID;

import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.UnimplementedOperationException;

/**
 * A very simple class that allows one to create an instance of an entity
 * when a specific type of entity is not required.
 * This should only be used for testing code that doesn't care what
 * type of entity it is.
 */
public class SimpleEntityMock extends EntityMock
{
	/**
	 * Creates a {@code SimpleEntityMock} with a specified UUID.
	 * @param uuid The UUID that the entity should have.
	 */
	public SimpleEntityMock(ServerMock server, UUID uuid)
	{
		super(server, uuid);
	}


	/**
	 * Creates a {@code SimpleEntityMock} with a random UUID.
	 */
	public SimpleEntityMock(ServerMock server)
	{
		this(server, UUID.randomUUID());
	}

	@Override
	public Spigot spigot()
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}
}
