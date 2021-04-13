package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Job
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-13T12:14:18.539Z[GMT]")

@Entity
public class Job {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @JsonProperty("vehicle")
    private Long vehicle = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("date")
    private LocalDate date = null;
    @JsonProperty("status")
    private StatusEnum status = null;

    public Job id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @Schema(required = true, description = "")
    @NotNull

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job vehicle(Long vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    /**
     * Get vehicle
     *
     * @return vehicle
     **/
    @Schema(description = "")

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    public Job description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @Schema(example = "Replace cabin air filter", required = true, description = "")
    @NotNull

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job date(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    @Schema(example = "Fri Jul 21 00:00:00 GMT 2017", required = true, description = "")
    @NotNull

    @Valid
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Job status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * job status in the store
     *
     * @return status
     **/
    @Schema(required = true, description = "job status in the store")
    @NotNull

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return Objects.equals(this.id, job.id) &&
                Objects.equals(this.vehicle, job.vehicle) &&
                Objects.equals(this.description, job.description) &&
                Objects.equals(this.date, job.date) &&
                Objects.equals(this.status, job.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicle, description, date, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Job {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    vehicle: ").append(toIndentedString(vehicle)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * job status in the store
     */
    public enum StatusEnum {
        CREATED("created"),

        SCHEDULED("scheduled"),

        STARTED("started"),

        DONE("done");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}
