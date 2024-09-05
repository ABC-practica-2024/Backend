package ro.ubb.abc2024.biology.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Bone;
import ro.ubb.abc2024.biology.domain.Extremities.*;
import ro.ubb.abc2024.biology.domain.appendicular.*;
import ro.ubb.abc2024.biology.domain.axial.*;
import ro.ubb.abc2024.biology.dto.BoneDto;
import ro.ubb.abc2024.biology.mapper.BoneMapper;
import ro.ubb.abc2024.biology.mapper.Extremities.*;
import ro.ubb.abc2024.biology.mapper.append.*;
import ro.ubb.abc2024.biology.mapper.axial.*;
import ro.ubb.abc2024.biology.service.BoneService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/bones")
public class BoneController {

    private final BoneMapper boneMapper;

    private final CoccyxMapper coccyxMapper;
    private final RibsMapper ribsMapper;
    private final SacrumMapper sacrumMapper;
    private final SternumMapper sternumMapper;
    private final VertebraeMapper vertebraeMapper;
    private final ClavicleMapper clavicleMapper;
    private final FemurMapper femurMapper;
    private final FibulaMapper fibulaMapper;
    private final HumerusMapper humerusMapper;
    private final IliumMapper iliumMapper;
    private final InnominateOsCoxaHipBoneMapper innominateOsCoxaHipBoneMapper;
    private final IschiumMapper ischiumMapper;
    private final PatellaMapper patellaMapper;
    private final PubisMapper pubisMapper;
    private final RadiusMapper radiusMapper;
    private final ScapulaMapper scapulaMapper;
    private final TibiaMapper tibiaMapper;
    private final UlnaMapper ulnaMapper;
    private final CalcaneusMapper calcaneusMapper;
    private final CarpalsMapper carpalsMapper;
    private final MetacarpalsMapper metacarpalsMapper;
    private final MetatarsalsMapper metatarsalsMapper;
    private final OtherTarsalsMapper otherTarsalsMapper;
    private final PhalangesMapper phalangesMapper;

    @Autowired
    private BoneService boneService;

    @GetMapping("/{artefactId}")
    public Result<List<BoneDto>> getBonesByArtefactId(@PathVariable UUID artefactId) {
        List<Bone> bones = boneService.getBonesByArtefactId(artefactId);
        if (bones.isEmpty()) {
            return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Bones not found for specified artifactId", null);
        }
        List<BoneDto> boneDtos = bones.stream().map(bone -> {
            if (bone instanceof Coccyx) {
                return coccyxMapper.toDto((Coccyx) bone);
            } else if (bone instanceof Ribs) {
                return ribsMapper.toDto((Ribs) bone);
            } else if (bone instanceof Sacrum) {
                return sacrumMapper.toDto((Sacrum) bone);
            } else if (bone instanceof Sternum) {
                return sternumMapper.toDto((Sternum) bone);
            } else if (bone instanceof Vertebrae) {
                return vertebraeMapper.toDto((Vertebrae) bone);
            } else if (bone instanceof Clavicle) {
                return clavicleMapper.toDto((Clavicle) bone);
            } else if (bone instanceof Femur) {
                return femurMapper.toDto((Femur) bone);
            } else if (bone instanceof Fibula) {
                return fibulaMapper.toDto((Fibula) bone);
            } else if (bone instanceof Humerus) {
                return humerusMapper.toDto((Humerus) bone);
            } else if (bone instanceof Ilium) {
                return iliumMapper.toDto((Ilium) bone);
            } else if (bone instanceof InnominateOsCoxaHipBone) {
                return innominateOsCoxaHipBoneMapper.toDto((InnominateOsCoxaHipBone) bone);
            } else if (bone instanceof Ischium) {
                return ischiumMapper.toDto((Ischium) bone);
            } else if (bone instanceof Patella) {
                return patellaMapper.toDto((Patella) bone);
            } else if (bone instanceof Pubis) {
                return pubisMapper.toDto((Pubis) bone);
            } else if (bone instanceof Radius) {
                return radiusMapper.toDto((Radius) bone);
            } else if (bone instanceof Scapula) {
                return scapulaMapper.toDto((Scapula) bone);
            } else if (bone instanceof Tibia) {
                return tibiaMapper.toDto((Tibia) bone);
            } else if (bone instanceof Ulna) {
                return ulnaMapper.toDto((Ulna) bone);
            } else if (bone instanceof Calcaneus) {
                return calcaneusMapper.toDto((Calcaneus) bone);
            } else if (bone instanceof Carpals) {
                return carpalsMapper.toDto((Carpals) bone);
            } else if (bone instanceof Metacarpals) {
                return metacarpalsMapper.toDto((Metacarpals) bone);
            } else if (bone instanceof Metatarsals) {
                return metatarsalsMapper.toDto((Metatarsals) bone);
            } else if (bone instanceof OtherTarsals) {
                return otherTarsalsMapper.toDto((OtherTarsals) bone);
            } else if (bone instanceof Phalanges) {
                return phalangesMapper.toDto((Phalanges) bone);
            }
            return boneMapper.toDto(bone);
        }).collect(Collectors.toList());

        return new Result<>(true, HttpStatus.OK.value(), "Here is the list of bones", boneDtos);
    }

}
