// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.plugins.streetside.io.download;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.function.Function;

import org.openstreetmap.josm.data.Bounds;
import org.openstreetmap.josm.plugins.streetside.StreetsideData;
import org.openstreetmap.josm.plugins.streetside.utils.StreetsideURL.APIv3;

public class DetectionsDownloadRunnable extends BoundsDownloadRunnable {

  private static final Function<Bounds, URL> URL_GEN = APIv3::searchDetections;

  private final StreetsideData data;

  public DetectionsDownloadRunnable(final StreetsideData data, final Bounds bounds) {
    super(bounds);
    this.data = data;
  }

  @Override
  public void run(final URLConnection con) throws IOException {
    /*try (JsonReader reader = Json.createReader(new BufferedInputStream(con.getInputStream()))) {
      final long startTime = System.currentTimeMillis();
      Map<String, List<ImageDetection>> detections = JsonDecoder.decodeFeatureCollection(
        reader.readObject(),
        JsonImageDetectionDecoder::decodeImageDetection
      ).stream().collect(Collectors.groupingBy(ImageDetection::getImageKey));
      logConnectionInfo(con, String.format("%d detections in %.2f s", detections.size(), (System.currentTimeMillis() - startTime) / 1000F));

      for (Entry<String, List<ImageDetection>> entry : detections.entrySet()) {
        data.getImages().stream()
          .filter(img -> img instanceof StreetsideImage && ((StreetsideImage) img).getKey().equals(entry.getKey()))
          .forEach(img -> ((StreetsideImage) img).setAllDetections(entry.getValue()));
      }
    } catch (JsonException | NumberFormatException e) {
      throw new IOException(e);
    }
    StreetsideLayer.invalidateInstance();*/
  }

  @Override
  protected Function<Bounds, URL> getUrlGenerator() {
    return URL_GEN;
  }
}
