package petition.petition.domain.ban.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petition.petition.domain.ban.domain.repository.BanRepository;
import petition.petition.domain.ban.presentation.dto.response.BanListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetBanListService {

    private final BanRepository banRepository;

    public List<BanListResponse> getBan() {

        return banRepository.findAll()
                .stream()
                .map(BanListResponse::new)
                .collect(Collectors.toList());
    }
}