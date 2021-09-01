package com.itheima.authority.api.v1.hystrix;

import com.itheima.authority.api.v1.OrgApi;
import com.itheima.authority.api.v1.dto.OrgDTO;
import com.itheima.authority.api.v1.dto.OrgUserTreeDTO;
import com.itheima.authority.common.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrgFailback implements OrgApi {
    @Override
    public R<OrgDTO> get(Long id) {
        return R.timeout();
    }

    @Override
    public R<List<OrgUserTreeDTO>> orgUserTree() {
        return R.timeout();
    }
}
