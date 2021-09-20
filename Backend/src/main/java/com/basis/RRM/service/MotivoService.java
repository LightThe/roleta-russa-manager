package com.basis.RRM.service;


import com.basis.RRM.dominio.Motivo;
import com.basis.RRM.repository.MotivoRepository;
import com.basis.RRM.service.dto.MotivoDTO;
import com.basis.RRM.service.mapper.MotivoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class MotivoService {

   private final MotivoRepository motivoRepository;
   private final MotivoMapper motivoMapper;


   public List<MotivoDTO> exibirTodosMotivos(){

       return motivoMapper.toDto(motivoRepository.findAll());
   }

   public MotivoDTO exibirMotivoPorId(Long id){
       Motivo motivo = motivoRepository.getById(id);
       return motivoMapper.toDto(motivo);
   }

   public MotivoDTO salvarMotivo(MotivoDTO motivoDTO){
       Motivo motivo = motivoMapper.toEntity(motivoDTO);
       Motivo motivoSalvar = motivoRepository.save(motivo);
       return motivoMapper.toDto(motivoSalvar);
   }
   public void deletarMotivo(Long id){
       motivoRepository.deleteById(id);
   }
}
