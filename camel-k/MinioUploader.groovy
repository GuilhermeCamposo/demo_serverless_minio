rest()
.post()
  .route()
    .setHeader("CamelMinioObjectName", simple('demo-file-${date:now:yyyyMMddHHmmss}.txt'))
    .to('minio:camel-k-bucket?accessKey={{s3.accesskey}}&secretKey={{s3.secretkey}}&endpoint={{s3.url}}&region={{s3.region}}')
    .log('${header.CamelMinioObjectName} file uploaded.')
    .setBody(constant("File uploaded."))
.endRest();
