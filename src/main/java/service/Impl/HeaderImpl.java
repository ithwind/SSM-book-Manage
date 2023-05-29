package service.Impl;

import mapper.HeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.HeaderService;
@Service
public class HeaderImpl implements HeaderService {

    @Autowired
    private HeaderMapper headerMapper;

    @Override
    public int borrowCount() {
        return headerMapper.borrowCount();
    }

    @Override
    public int bookCount() {
        return headerMapper.bookCount();
    }

    @Override
    public int userCount() {
        return headerMapper.userCount();
    }

    @Override
    public int remainBookCount() {
        return headerMapper.remainBookCount();
    }
}
