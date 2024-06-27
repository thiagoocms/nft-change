package com.nftchange.gateway;

import com.nftchange.domain.NFT;
import com.nftchange.mapper.NFTEntityMapper;
import com.nftchange.persistence.entity.NFTEntity;
import com.nftchange.persistence.repository.NFTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NFTGatewayImpl implements NFTGateway {

    private final NFTRepository nftRepository;

    @Autowired
    public NFTGatewayImpl(NFTRepository nftRepository) {
        this.nftRepository = nftRepository;
    }


    @Override
    public NFT create(NFT nft) {
        NFTEntity nftEntity = NFTEntityMapper.toEntity(nft);
        nft = NFTEntityMapper.toDomain(this.nftRepository.save(nftEntity));
        return nft;
    }

    @Override
    public NFT findById(UUID id) {
        NFTEntity nftEntity = this.nftRepository.findFirstByTokenIdAndDeletedIsFalse(id.toString());
        return NFTEntityMapper.toDomain(nftEntity);
    }

    @Override
    public NFT update(NFT nft) {
        NFTEntity nftEntity = NFTEntityMapper.toEntity(nft);
        nft = NFTEntityMapper.toDomain(this.nftRepository.save(nftEntity));
        return nft;
    }

    @Override
    public void deleteById(UUID id) {
        NFTEntity nftEntity = this.nftRepository.findFirstByTokenIdAndDeletedIsFalse(id.toString());
        nftEntity.setDeleted(Boolean.TRUE);
        this.nftRepository.save(nftEntity);
    }

    @Override
    public List<NFT> findAllByTitle(String title) {
        List<NFTEntity> nftEntityList = this.nftRepository.findAllByTitle(title);
        return nftEntityList.stream().map(NFTEntityMapper::toDomain).toList();
    }
}
