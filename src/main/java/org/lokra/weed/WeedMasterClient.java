package org.lokra.weed;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.lokra.weed.content.*;

import java.io.File;

public interface WeedMasterClient {
    @RequestLine("OPTIONS /status")
    void checkAlive();

    @RequestLine("POST /submit?collection={collection}&count={count}")
    @Headers("Content-Type: multipart/form-data")
    WeedFile upload(@Param("file") File file, @Param("collection") String collection, @Param("count") int count);

    @RequestLine("POST /submit?collection={collection}&count={count}")
    @Headers("Content-Type: multipart/form-data")
    WeedFile upload(@Param("file") byte[] bytes, @Param("collection") String collection, @Param("count") int count);

    @RequestLine("POST /submit?collection={collection}&count={count}")
    @Headers("Content-Type: multipart/form-data")
    WeedFile upload(@Param("file") String content, @Param("collection") String collection, @Param("count") int count);

    @RequestLine("GET /dir/assign?replication={replication}&count={count}&dataCenter={dataCenter}&ttl={ttl}")
    Assign assign(@Param("replication") String replication, @Param("count") Integer count, @Param("dataCenter") String dataCenter, @Param("ttl") String ttl);

    @RequestLine("GET /dir/lookup?volumeId={volumeId}&collection={collection}")
    Locations lookup(@Param("volumeId") Integer volumeId, @Param("collection") String collection);

    @RequestLine("GET /vol/vacuum?garbageThreshold={garbageThreshold}")
    void vacuum(@Param("garbageThreshold") Double garbageThreshold);

    @RequestLine("GET /vol/grow?replication={replication}&count={count}&dataCenter={dataCenter}&ttl={ttl}")
    Grow grow(@Param("replication") String replication, @Param("count") Integer count, @Param("dataCenter") String dataCenter, @Param("ttl") String ttl);

    @RequestLine("GET /cluster/status")
    Cluster cluster();

    @RequestLine("GET /dir/status")
    MasterStatus status();
}
