package com.ssg.w2.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

//object mapping 서로 다른 클래스의 값을 한번에 복사하게 도와주는 라이브러리
//필요에 의해 dto와 vd를 내가 원하는 타입으로 변환하는 기능
public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;
    MapperUtil(){

        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get(){
        return modelMapper;
    }
}
