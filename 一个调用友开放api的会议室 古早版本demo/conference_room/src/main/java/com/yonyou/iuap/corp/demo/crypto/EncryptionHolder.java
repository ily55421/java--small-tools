package com.yonyou.iuap.corp.demo.crypto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 加密后的消息载体
 * @author 14688
 */
@Getter
@Setter
@Builder
public class EncryptionHolder {

    /**
     * 消息签名
     */
    private String msgSignature;

    /**
     * 消息发送 unix 时间戳
     */
    private long timestamp;

    /**
     * 随机值，盐
     */
    private String nonce;

    /**
     * AES -> BASE64 之后的消息体
     */
    private String encrypt;

    public EncryptionHolder() {
    }

    public EncryptionHolder(String msgSignature, long timestamp, String nonce, String encrypt) {
        this.msgSignature = msgSignature;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.encrypt = encrypt;
    }

    public EncryptionHolder(long timestamp, String nonce) {
        this.timestamp = timestamp;
        this.nonce = nonce;
    }

}
