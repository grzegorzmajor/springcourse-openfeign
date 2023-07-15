package ovh.major.springcourseopenfeigh;

import java.util.List;

public record ITunesResponse (Integer resultCount, List<ITunesResults> results) {
}
