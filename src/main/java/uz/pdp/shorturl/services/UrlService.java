package uz.pdp.shorturl.services;

import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import uz.pdp.shorturl.dtos.url.WeaklyReport;
import uz.pdp.shorturl.entities.Url;

public interface UrlService {
    Url shortenUrl(@NonNull UrlCreateDTO dto);

    Url getByCode(@NonNull String code);

    Page<Url> getPage(int page, int size);

    WeaklyReport getWeaklyReport();
    void sendWeaklyReport();
}
