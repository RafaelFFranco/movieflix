package dev.movieflix.movieflix.Service;

import dev.movieflix.movieflix.Repository.StreamingRepository;
import org.springframework.stereotype.Service;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;
    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }
}
