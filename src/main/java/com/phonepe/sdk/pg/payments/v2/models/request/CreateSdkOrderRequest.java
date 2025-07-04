/*
 *  Copyright (c) 2025 Original Author(s), PhonePe India Pvt. Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.phonepe.sdk.pg.payments.v2.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.phonepe.sdk.pg.common.models.MetaInfo;
import com.phonepe.sdk.pg.common.models.request.InstrumentConstraint;
import com.phonepe.sdk.pg.common.models.request.PaymentFlow;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CreateSdkOrderRequest {

    private String merchantOrderId;
    private long amount;
    private MetaInfo metaInfo;
    private PaymentFlow paymentFlow;
    private Long expireAfter;
    private List<InstrumentConstraint> constraints;

    /**
     * Builds SDK order Request
     *
     * @param amount Order amount in paisa
     * @param merchantOrderId The unique order ID generated by the merchant
     * @param metaInfo Merchant defined meta info to store additional information
     * @param message Payment message shown in APP for collect requests
     * @param redirectUrl URL where user will be redirected after success/failed payment
     */
    @Builder(
            builderClassName = "StandardCheckoutBuilder",
            builderMethodName = "StandardCheckoutBuilder")
    public CreateSdkOrderRequest(
            long amount,
            @NotNull String merchantOrderId,
            MetaInfo metaInfo,
            String message,
            String redirectUrl,
            Long expireAfter) {
        this.merchantOrderId = merchantOrderId;
        this.amount = amount;
        this.metaInfo = metaInfo;
        this.expireAfter = expireAfter;
        MerchantUrls merchantUrls = MerchantUrls.builder().redirectUrl(redirectUrl).build();
        this.setPaymentFlow(
                PgCheckoutPaymentFlow.builder()
                        .message(message)
                        .merchantUrls(merchantUrls)
                        .build());
    }

    /**
     * Builds SDK order Request
     *
     * @param amount Order amount in paisa
     * @param merchantOrderId The unique order ID generated by the merchant
     * @param metaInfo Merchant defined meta info to store additional information
     * @param constraints Different type of constraints that must be applied to the payment
     */
    @Builder(
            builderClassName = "CustomCheckoutBuilder",
            builderMethodName = "CustomCheckoutBuilder")
    public CreateSdkOrderRequest(
            @NotNull String merchantOrderId,
            long amount,
            MetaInfo metaInfo,
            List<InstrumentConstraint> constraints,
            Long expireAfter) {
        this.merchantOrderId = merchantOrderId;
        this.amount = amount;
        this.metaInfo = metaInfo;
        this.expireAfter = expireAfter;
        this.constraints = constraints;
        this.setPaymentFlow(PgPaymentFlow.builder().build());
    }
}
