
package com.rentvideo.controller;

import com.rentvideo.dto.VideoRequest;
import com.rentvideo.entity.Video;
import com.rentvideo.service.VideoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping
    public List<Video> getAvailableVideos() {
        return videoService.getAvailableVideos();
    }

    @GetMapping("/{id}")
    public Video getVideo(@PathVariable Long id) {
        return videoService.getVideo(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Video createVideo(@Valid @RequestBody VideoRequest request) {
        return videoService.createVideo(request);
    }

    @PutMapping("/{id}")
    public Video updateVideo(
            @PathVariable Long id,
            @Valid @RequestBody VideoRequest request) {
        return videoService.updateVideo(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }
}
