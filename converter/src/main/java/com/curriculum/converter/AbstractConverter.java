package com.curriculum.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic abstract converter, that implements two methods: convertAll with different signatures.
 *
 * @param <SOURCE> From what class to convert
 * @param <TARGET> To what class to convert
 */
public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET> {

    @Override
    public List<TARGET> convertAll(final List<SOURCE> sources) {

        return convertAll(sources, new ArrayList<TARGET>(sources.size()));
    }

    @Override
    public List<TARGET> convertAll(final List<SOURCE> sources, final List<TARGET> targets) {

        targets.addAll(sources.stream().map(this::convert).collect(Collectors.toList()));

        return targets;
    }
}
