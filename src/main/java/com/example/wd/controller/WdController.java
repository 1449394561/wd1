package com.example.wd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.wd.entity.Wd;
import com.example.wd.mapper.WdMapper;
import com.example.wd.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController()
@RequestMapping("/wd")
public class WdController {

    @Autowired
    private WdMapper wdMapper;

    @PostMapping("/login")
    public Result<?> login(@RequestBody Wd wd) {
        Wd userPwd = wdMapper.selectByName(wd.getName());
        QueryWrapper<Wd> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", wd.getName());
        queryWrapper.eq("password", wd.getPassword());
        Wd res = wdMapper.selectOne(queryWrapper);
        if (res == null){
            return Result.error("-1", "密码错误");
        }
        return Result.success(res);
        }



    @GetMapping("/all")
    public List<Wd> select(){
        List<Wd> wslist=wdMapper.selectList(null);
        System.out.println(wslist);
        return wslist;
    }


    @PostMapping("/update")
    public Result update(@RequestBody Wd wd){
        wdMapper.updateById(wd);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        wdMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Wd wd){
        wdMapper.insert(wd);
        return Result.success();
    }

    @GetMapping("/gl/{id}")
    public List<Wd> selectgl(@PathVariable Integer id){
        List<Wd> wslist=wdMapper.findAll(id);

        System.out.println(wslist);
        return wslist;
    }
}
