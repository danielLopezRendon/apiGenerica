package com.prueba.completa.bancolombia.utils;

import java.util.List;

import org.modelmapper.ModelMapper;

public abstract class ConvertDtos {

    public <Dto,Entidad> Dto returnDto(Entidad source,Class<Dto> target){
        var modelMapper=new ModelMapper();
        return modelMapper.map(source, target);
    }

    public <Dto,Entidad> List<Dto> returnListDto(List<Entidad> source,Class<Dto> target){
        var modelMapper=new ModelMapper();
        return source.stream().map(fuente->modelMapper.map(fuente,target)).toList();
    }
    
}
