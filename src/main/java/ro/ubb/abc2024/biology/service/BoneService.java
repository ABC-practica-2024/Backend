package ro.ubb.abc2024.biology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.domain.Extremities.*;
import ro.ubb.abc2024.biology.domain.appendicular.*;
import ro.ubb.abc2024.biology.domain.axial.*;
import ro.ubb.abc2024.biology.repository.Extremities.ExtremityRepository;
import ro.ubb.abc2024.biology.repository.appendicular.AppendRepository;
import ro.ubb.abc2024.biology.repository.axial.AxialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BoneService {

    @Autowired
    private ExtremityRepository extremityRepository;

    @Autowired
    private AppendRepository appendRepository;

    @Autowired
    private AxialRepository axialRepository;


    public List<Bone> getBonesByArtefactId(UUID artefactId) {
        List<Bone> allBones = new ArrayList<>();

        List<Calcaneus> calcaneus = extremityRepository.findCalcaneusAllByArtefactId(artefactId);
        allBones.addAll(calcaneus);
        List<Carpals> carpals = extremityRepository.findAllCarpalsByArtefactId(artefactId);
        allBones.addAll(carpals);
        List<Metacarpals> metacarpals = extremityRepository.findAllMetacarpalsByArtefactId(artefactId);
        allBones.addAll(metacarpals);
        List<Metatarsals> metatarsals = extremityRepository.findAllMetatarsalsByArtefactId(artefactId);
        allBones.addAll(metatarsals);
        List<OtherTarsals> otherTarsals = extremityRepository.findAllOtherTarsalsByArtefactId(artefactId);
        allBones.addAll(otherTarsals);
        List<Phalanges> phalanges = extremityRepository.findAllPhalangesByArtefactId(artefactId);
        allBones.addAll(phalanges);

        List<Coccyx> coccyx = axialRepository.findAllCoccyxByArtefactId(artefactId);
        allBones.addAll(coccyx);
        List<Ribs> ribs = axialRepository.findAllRibsByArtefactId(artefactId);
        allBones.addAll(ribs);
        List<Sacrum> sacrum = axialRepository.findAllSacrumByArtefactId(artefactId);
        allBones.addAll(sacrum);
        List<Sternum> sternum = axialRepository.findAllSternumByArtefactId(artefactId);
        allBones.addAll(sternum);
        List<Vertebrae> vertebrae = axialRepository.findAllVertebraeByArtefactId(artefactId);
        allBones.addAll(vertebrae);

        List<Clavicle> clavicle = appendRepository.findAllClavicleByArtefactId(artefactId);
        allBones.addAll(clavicle);
        List<Femur> femur = appendRepository.findAllFemurByArtefactId(artefactId);
        allBones.addAll(femur);
        List<Fibula> fibula = appendRepository.findAllFibulaByArtefactId(artefactId);
        allBones.addAll(fibula);
        List<Humerus> humerus = appendRepository.findAllHumerusByArtefactId(artefactId);
        allBones.addAll(humerus);
        List<Ilium> ilium = appendRepository.findAllIliumByArtefactId(artefactId);
        allBones.addAll(ilium);
        List<InnominateOsCoxaHipBone> innominateOsCoxaHipBone = appendRepository.findAllInnominateOsCoxaHipBoneByArtefactId(artefactId);
        allBones.addAll(innominateOsCoxaHipBone);
        List<Ischium> ischium = appendRepository.findAllIschiumByArtefactId(artefactId);
        allBones.addAll(ischium);
        List<Patella> patella = appendRepository.findAllPatellaByArtefactId(artefactId);
        allBones.addAll(patella);
        List<Pubis> pubis = appendRepository.findAllPubisByArtefactId(artefactId);
        allBones.addAll(pubis);
        List<Radius> radius = appendRepository.findAllRadiusByArtefactId(artefactId);
        allBones.addAll(radius);
        List<Scapula> scapula = appendRepository.findAllScapulaByArtefactId(artefactId);
        allBones.addAll(scapula);
        List<Tibia> tibia = appendRepository.findAllTibiaByArtefactId(artefactId);
        allBones.addAll(tibia);
        List<Ulna> ulna = appendRepository.findAllUlnaByArtefactId(artefactId);
        allBones.addAll(ulna);

        return allBones;
    }
}
