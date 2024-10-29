package com.example.controller;

import com.example.common.Result;
import com.example.entity.Hotel;
import com.example.entity.Params;
import com.example.service.HotelService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Resource
    private HotelService hotelService;

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        PageInfo<Hotel> info = hotelService.findBySearch(params);
        return Result.success(info);
    }

    @PostMapping
    public Result save(@RequestBody Hotel hotel) {
        if (hotel.getId() == null) {
            hotelService.add(hotel);
        } else {
            hotelService.update(hotel);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        hotelService.delete(id);
        return Result.success();
    }

}