package com.servicediabetes.ApiDiabetesDomain.Tratamiento;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;

import java.util.List;




@Service
public class TratamientoServiceImpl implements TratamientoService {
    private final TratamientoRepositoryHb tratamientoRepositoryHb;
    private final TratamientoRepository tratamientoRepository;
    private final TratamientoUtils tratamientoUtils;

    public TratamientoServiceImpl(TratamientoRepositoryHb tratamientoRepositoryHb, TratamientoRepository tratamientoRepository, TratamientoUtils tratamientoUtils) {
        this.tratamientoRepositoryHb = tratamientoRepositoryHb;
        this.tratamientoRepository = tratamientoRepository;
        this.tratamientoUtils = tratamientoUtils;
    }

    @Transactional
    @Override
    public TratamientoDtos createTratamiento(TratamientoDtos request) {
        try {
            Tratamiento tratamiento = tratamientoUtils.convertToEntity(request);
            tratamiento = tratamientoRepository.save(tratamiento);
            TratamientoDtos tratamientoDtos = tratamientoUtils.convertToDto(tratamiento);
            return tratamientoDtos;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public TratamientoDtos getTratamientoById(Long id) {
        try {
            Tratamiento tratamiento = tratamientoRepositoryHb.getTratamientoById(id);
            if (tratamiento == null) {
                return null;
            } else {
                TratamientoDtos tratamientoDtos = tratamientoUtils.convertToDto(tratamiento);
                return tratamientoDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TratamientoDtos> getAllTratamiento() {
        try {
            List<Tratamiento> listResult = tratamientoRepository.findAll();
            if (listResult.isEmpty()) {
                return null;
            } else {
                List<TratamientoDtos> listTratamientoDtos = tratamientoUtils.convertToDtoList(listResult);
                return listTratamientoDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean deleteTratamiento(Long id) {
        try {
            Tratamiento tratamiento = tratamientoRepositoryHb.getTratamientoById(id);
            if (tratamiento == null) {
                return false;
            } else {
                tratamientoRepository.delete(tratamiento);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public TratamientoDtos updateTratamiento(Long id, TratamientoDtos request) {
        try {
            Tratamiento tratamiento = tratamientoRepositoryHb.getTratamientoById(id);
            if (tratamiento == null) {
                return null;
            } else {
                tratamiento.setFecha_inicio(request.getFecha_inicio());
                tratamiento.setFecha_fin(request.getFecha_fin());
                tratamiento = tratamientoRepository.save(tratamiento);
                TratamientoDtos tratamientoDtos = tratamientoUtils.convertToDto(tratamiento);
                return tratamientoDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
