package com.nftchange.controller;

import com.nftchange.constants.AppConstants;
import com.nftchange.domain.NFT;
import com.nftchange.dto.NFTDTO;
import com.nftchange.mapper.NFTDTOMapper;
import com.nftchange.nft.CreateNFTUseCase;
import com.nftchange.nft.DeleteNFTByIdUseCase;
import com.nftchange.nft.FindNFTByIdUseCase;
import com.nftchange.nft.UpdateNFTByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = AppConstants.PATH + AppConstants.API + AppConstants.V1 + "/nfts")
public class NFTController {

    private final CreateNFTUseCase createNFTUseCase;
    private final UpdateNFTByIdUseCase updateNFTByIdUseCase;
    private final FindNFTByIdUseCase findNFTByIdUseCase;
    private final DeleteNFTByIdUseCase deleteNFTByIdUseCase;

    @Autowired
    public NFTController(CreateNFTUseCase createNFTUseCase, UpdateNFTByIdUseCase updateNFTByIdUseCase, FindNFTByIdUseCase findNFTByIdUseCase, DeleteNFTByIdUseCase deleteNFTByIdUseCase) {
        this.createNFTUseCase = createNFTUseCase;
        this.updateNFTByIdUseCase = updateNFTByIdUseCase;
        this.findNFTByIdUseCase = findNFTByIdUseCase;
        this.deleteNFTByIdUseCase = deleteNFTByIdUseCase;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NFTDTO> create(@RequestBody NFTDTO dto) {

        NFT nft = this.createNFTUseCase.create(NFTDTOMapper.toDomain(dto));
        dto = NFTDTOMapper.toDto(nft);

        return ResponseEntity
                .created(URI.create("/nfts"))
                .body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NFTDTO> update(@PathVariable String id, @RequestBody NFTDTO dto) {

        NFT nft = this.updateNFTByIdUseCase.updateById(UUID.fromString(id), NFTDTOMapper.toDomain(dto));
        dto = NFTDTOMapper.toDto(nft);

        return ResponseEntity
                .ok()
                .body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NFTDTO> findById(@PathVariable String id) {

        NFTDTO nftdto = NFTDTOMapper.toDto(this.findNFTByIdUseCase.findById(UUID.fromString(id)));

        return ResponseEntity
                .ok()
                .body(nftdto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        deleteNFTByIdUseCase.deleteById(UUID.fromString(id));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
