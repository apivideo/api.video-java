/*
 * api.video Java API client
 * api.video is an API that encodes on the go to facilitate immediate playback, enhancing viewer streaming experiences across multiple devices and platforms. You can stream live or on-demand online videos within minutes.
 *
 * The version of the OpenAPI document: 1
 * Contact: ecosystem@api.video
 *
 * NOTE: This class is auto generated.
 * Do not edit the class manually.
 */

package video.api.client.api.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * FilterBy1
 */

public class FilterBy1 implements Serializable, DeepObject {
    private static final long serialVersionUID = 1L;

    public static final String SERIALIZED_NAME_MEDIA_ID = "mediaId";
    @SerializedName(SERIALIZED_NAME_MEDIA_ID)
    private List<String> mediaId = null;

    /**
     * Gets or Sets mediaType
     */
    @JsonAdapter(MediaTypeEnum.Adapter.class)
    public enum MediaTypeEnum {
        VIDEO("video"),

        LIVE_STREAM("live-stream");

        private String value;

        MediaTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static MediaTypeEnum fromValue(String value) {
            for (MediaTypeEnum b : MediaTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<MediaTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final MediaTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public MediaTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return MediaTypeEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_MEDIA_TYPE = "mediaType";
    @SerializedName(SERIALIZED_NAME_MEDIA_TYPE)
    private MediaTypeEnum mediaType;

    /**
     * Gets or Sets continent
     */
    @JsonAdapter(ContinentEnum.Adapter.class)
    public enum ContinentEnum {
        AS("AS"),

        AF("AF"),

        NA("NA"),

        SA("SA"),

        AN("AN"),

        EU("EU"),

        AZ("AZ");

        private String value;

        ContinentEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ContinentEnum fromValue(String value) {
            for (ContinentEnum b : ContinentEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<ContinentEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ContinentEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ContinentEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ContinentEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_CONTINENT = "continent";
    @SerializedName(SERIALIZED_NAME_CONTINENT)
    private List<ContinentEnum> continent = null;

    public static final String SERIALIZED_NAME_COUNTRY = "country";
    @SerializedName(SERIALIZED_NAME_COUNTRY)
    private List<String> country = null;

    public static final String SERIALIZED_NAME_DEVICE_TYPE = "deviceType";
    @SerializedName(SERIALIZED_NAME_DEVICE_TYPE)
    private List<String> deviceType = null;

    public static final String SERIALIZED_NAME_OPERATING_SYSTEM = "operatingSystem";
    @SerializedName(SERIALIZED_NAME_OPERATING_SYSTEM)
    private List<String> operatingSystem = null;

    public static final String SERIALIZED_NAME_BROWSER = "browser";
    @SerializedName(SERIALIZED_NAME_BROWSER)
    private List<String> browser = null;

    public static final String SERIALIZED_NAME_TAG = "tag";
    @SerializedName(SERIALIZED_NAME_TAG)
    private String tag;

    public static final String SERIALIZED_NAME_REFERRER = "referrer";
    @SerializedName(SERIALIZED_NAME_REFERRER)
    private List<URI> referrer = null;

    public FilterBy1 mediaId(List<String> mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public FilterBy1 addMediaIdItem(String mediaIdItem) {
        if (this.mediaId == null) {
            this.mediaId = new ArrayList<>();
        }
        this.mediaId.add(mediaIdItem);
        return this;
    }

    /**
     * Returns analytics based on the unique identifiers of a video or a live stream.
     * 
     * @return mediaId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"vi4blUQJFrYWbaG44NChkH27\"]", value = "Returns analytics based on the unique identifiers of a video or a live stream.")

    public List<String> getMediaId() {
        return mediaId;
    }

    public void setMediaId(List<String> mediaId) {
        this.mediaId = mediaId;
    }

    public FilterBy1 mediaType(MediaTypeEnum mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    /**
     * Get mediaType
     * 
     * @return mediaType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "video", value = "")

    public MediaTypeEnum getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaTypeEnum mediaType) {
        this.mediaType = mediaType;
    }

    public FilterBy1 continent(List<ContinentEnum> continent) {
        this.continent = continent;
        return this;
    }

    public FilterBy1 addContinentItem(ContinentEnum continentItem) {
        if (this.continent == null) {
            this.continent = new ArrayList<>();
        }
        this.continent.add(continentItem);
        return this;
    }

    /**
     * Returns analytics based on the viewers&#39; continent. The list of supported continents names are based on the
     * [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for
     * example &#x60;EU&#x60;.
     * 
     * @return continent
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"EU\"]", value = "Returns analytics based on the viewers' continent. The list of supported continents names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `EU`.")

    public List<ContinentEnum> getContinent() {
        return continent;
    }

    public void setContinent(List<ContinentEnum> continent) {
        this.continent = continent;
    }

    public FilterBy1 country(List<String> country) {
        this.country = country;
        return this;
    }

    public FilterBy1 addCountryItem(String countryItem) {
        if (this.country == null) {
            this.country = new ArrayList<>();
        }
        this.country.add(countryItem);
        return this;
    }

    /**
     * Returns analytics based on the viewers&#39; country. The list of supported country names are based on the
     * [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for
     * example &#x60;FR&#x60;.
     * 
     * @return country
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"FR\"]", value = "Returns analytics based on the viewers' country. The list of supported country names are based on the [GeoNames public database](https://www.geonames.org/countries/). You must use the ISO-3166 alpha2 format, for example `FR`.")

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public FilterBy1 deviceType(List<String> deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public FilterBy1 addDeviceTypeItem(String deviceTypeItem) {
        if (this.deviceType == null) {
            this.deviceType = new ArrayList<>();
        }
        this.deviceType.add(deviceTypeItem);
        return this;
    }

    /**
     * Returns analytics based on the type of device used by the viewers. Response values can include:
     * &#x60;computer&#x60;, &#x60;phone&#x60;, &#x60;tablet&#x60;, &#x60;tv&#x60;, &#x60;console&#x60;,
     * &#x60;wearable&#x60;, &#x60;unknown&#x60;.
     * 
     * @return deviceType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"computer\"]", value = "Returns analytics based on the type of device used by the viewers. Response values can include: `computer`, `phone`, `tablet`, `tv`, `console`, `wearable`, `unknown`.")

    public List<String> getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(List<String> deviceType) {
        this.deviceType = deviceType;
    }

    public FilterBy1 operatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    public FilterBy1 addOperatingSystemItem(String operatingSystemItem) {
        if (this.operatingSystem == null) {
            this.operatingSystem = new ArrayList<>();
        }
        this.operatingSystem.add(operatingSystemItem);
        return this;
    }

    /**
     * Returns analytics based on the operating system used by the viewers. Response values can include
     * &#x60;windows&#x60;, &#x60;mac osx&#x60;, &#x60;android&#x60;, &#x60;ios&#x60;, &#x60;linux&#x60;.
     * 
     * @return operatingSystem
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"windows\"]", value = "Returns analytics based on the operating system used by the viewers. Response values can include `windows`, `mac osx`, `android`, `ios`, `linux`.")

    public List<String> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public FilterBy1 browser(List<String> browser) {
        this.browser = browser;
        return this;
    }

    public FilterBy1 addBrowserItem(String browserItem) {
        if (this.browser == null) {
            this.browser = new ArrayList<>();
        }
        this.browser.add(browserItem);
        return this;
    }

    /**
     * Returns analytics based on the browser used by the viewers. Response values can include &#x60;chrome&#x60;,
     * &#x60;firefox&#x60;, &#x60;edge&#x60;, &#x60;opera&#x60;.
     * 
     * @return browser
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"firefox\"]", value = "Returns analytics based on the browser used by the viewers. Response values can include `chrome`, `firefox`, `edge`, `opera`.")

    public List<String> getBrowser() {
        return browser;
    }

    public void setBrowser(List<String> browser) {
        this.browser = browser;
    }

    public FilterBy1 tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read
     * more about tagging your videos [here](https://docs.api.video/vod/tags-metadata).
     * 
     * @return tag
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Cool videos", value = "Returns analytics for videos using this tag. This filter only accepts a single value and is case sensitive. Read more about tagging your videos [here](https://docs.api.video/vod/tags-metadata).")

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public FilterBy1 referrer(List<URI> referrer) {
        this.referrer = referrer;
        return this;
    }

    public FilterBy1 addReferrerItem(URI referrerItem) {
        if (this.referrer == null) {
            this.referrer = new ArrayList<>();
        }
        this.referrer.add(referrerItem);
        return this;
    }

    /**
     * Filters data based on the URL where the view is originating from. This filter parameter accepts an empty string
     * to filter view events where no referrer is available. - The API filters for exact matches. Include the trailing
     * &#x60;/&#x60; characters if needed. - The URLs you add must be URL encoded.
     * 
     * @return referrer
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"https%3A%2F%2Fmy-awesome-videos.com\"]", value = "Filters data based on the URL where the view is originating from. This filter parameter accepts an empty string to filter view events where no referrer is available.  - The API filters for exact matches. Include the trailing `/` characters if needed. - The URLs you add must be URL encoded.")

    public List<URI> getReferrer() {
        return referrer;
    }

    public void setReferrer(List<URI> referrer) {
        this.referrer = referrer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilterBy1 filterBy1 = (FilterBy1) o;
        return Objects.equals(this.mediaId, filterBy1.mediaId) && Objects.equals(this.mediaType, filterBy1.mediaType)
                && Objects.equals(this.continent, filterBy1.continent)
                && Objects.equals(this.country, filterBy1.country)
                && Objects.equals(this.deviceType, filterBy1.deviceType)
                && Objects.equals(this.operatingSystem, filterBy1.operatingSystem)
                && Objects.equals(this.browser, filterBy1.browser) && Objects.equals(this.tag, filterBy1.tag)
                && Objects.equals(this.referrer, filterBy1.referrer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, mediaType, continent, country, deviceType, operatingSystem, browser, tag,
                referrer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FilterBy1 {\n");
        sb.append("    mediaId: ").append(toIndentedString(mediaId)).append("\n");
        sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
        sb.append("    continent: ").append(toIndentedString(continent)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
        sb.append("    operatingSystem: ").append(toIndentedString(operatingSystem)).append("\n");
        sb.append("    browser: ").append(toIndentedString(browser)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
        sb.append("    referrer: ").append(toIndentedString(referrer)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
