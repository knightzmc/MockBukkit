package be.seeseemelk.mockbukkit.block;

import be.seeseemelk.mockbukkit.UnimplementedOperationException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class BlockStateMock implements BlockState
{

    private int typeId = 0;

    public BlockStateMock()
    {
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean hasMetadata(String metadataKey)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public Block getBlock()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public MaterialData getData()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public void setData(MaterialData data)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public Material getType()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public void setType(Material type)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public int getTypeId()
    {
        return typeId;
    }

    @Override
    public byte getLightLevel()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public World getWorld()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public int getX()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public int getY()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public int getZ()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public Location getLocation()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public Location getLocation(Location loc)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public Chunk getChunk()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean setTypeId(int type)
    {
        this.typeId = type;
        return true;
    }

    @Override
    public boolean update()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean update(boolean force)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    @Deprecated
    public byte getRawData()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    @Deprecated
    public void setRawData(byte data)
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean isPlaced()
    {
        // TODO Auto-generated method stub
        throw new UnimplementedOperationException();
    }
}
