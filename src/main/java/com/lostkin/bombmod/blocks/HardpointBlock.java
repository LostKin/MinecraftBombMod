package com.lostkin.bombmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HardpointBlock extends Block {

    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public static final VoxelShape UP = Shapes.box(0, 0, 0, 1, 0.5, 1);
    public static final VoxelShape DOWN = Shapes.box(0, 0.5, 0, 1, 1, 1);
    public static final VoxelShape NORTH = Shapes.box(0, 0, 0.5, 1, 1, 1);
    public static final VoxelShape SOUTH = Shapes.box(0, 0, 0, 1, 1, 0.5);
    public static final VoxelShape EAST = Shapes.box(0, 0, 0, 0.5, 1, 1);
    public static final VoxelShape WEST = Shapes.box(0.5, 0, 0, 1, 1, 1);


    public HardpointBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.UP));
    }

    @Override
    protected  void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public VoxelShape getShape(BlockState states, BlockGetter getter, BlockPos pos, CollisionContext context) {
        switch (states.getValue(FACING)) {
            case DOWN -> {
                return DOWN;
            }
            case UP -> {
                return UP;
            }
            case NORTH -> {
                return NORTH;
            }
            case SOUTH -> {
                return SOUTH;
            }
            case WEST -> {
                return WEST;
            }
            case EAST -> {
                return EAST;
            }
        }
        return null;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }
}
