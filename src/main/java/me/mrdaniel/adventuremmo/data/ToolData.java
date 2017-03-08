package me.mrdaniel.adventuremmo.data;

import java.util.Optional;

import javax.annotation.Nonnull;

import me.mrdaniel.adventuremmo.enums.ToolType;

public class ToolData {

	private final ToolType type;

	public ToolData(@Nonnull final ToolType type) {
		this.type = type;
	}

	@Nonnull
	public ToolType getType() {
		return this.type;
	}

	@Nonnull
	public String serialize() {
		return this.type.getID();
	}

	@Nonnull
	public static Optional<ToolData> deserialize(@Nonnull final String str) {
		try { return Optional.of(new ToolData(ToolType.of(str).get())); }
		catch (final Exception exc) { return Optional.empty(); }
	}
}