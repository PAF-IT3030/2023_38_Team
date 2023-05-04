package Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Status;
import Repository.StatusRepo;

@Service
public class StatusService {

    @Autowired
    StatusRepo statusRepo;

    @Autowired
    StatusService userService;

    public Status submitDataIntoDB(Status status) {
        return statusRepo.save(status);
    }

    public ArrayList<Status> retrieveStatus() {

        ArrayList<Status> statusList = statusRepo.findAll();

        for (int i = 0; i < statusList.size(); i++) {
            Status statusItem = statusList.get(i);
            statusItem.setStatusName(userService.displayUserMetaData(statusItem.getUserId()).getUserName());
        }

        return statusList;
    }

    private Status displayUserMetaData(String userId) {
        return null;
    }
}